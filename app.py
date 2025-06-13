from flask import Flask, request
import time
import threading

app = Flask(__name__)
STOCK_FILE = 'stock.txt'
stock_lock = threading.Lock()  # Lock untuk mencegah race condition

@app.route('/buy', methods=['POST'])
def buy():
    item = request.form.get('item', 'banana')
    qty = int(request.form.get('qty', '1'))

    try:
        with stock_lock:  # hanya satu thread yang bisa masuk dalam satu waktu
            with open(STOCK_FILE, 'r') as f:
                stock_data = f.read().strip()

            if not stock_data.isdigit():
                return "Stock file corrupted or unreadable", 500

            stock = int(stock_data)

            if stock < qty:
                return f"Insufficient stock! Available: {stock}", 400

            stock -= qty

            with open(STOCK_FILE, 'w') as f:
                f.write(str(stock))

        # Critical section berakhir
        return f"Successfully bought {qty} {item}(s). Remaining: {stock}"

    except Exception as e:
        return f"Internal error: {e}", 500

if __name__ == '__main__':
    with open(STOCK_FILE, 'w') as f:
        f.write('10')
    app.run(debug=True, threaded=True)
