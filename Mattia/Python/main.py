import yfinance as yf
import pandas as pd

f = open("lista.txt")
stocks = f.readlines()
numero_righe = len(f.readlines())

for i in range(0,len(stocks)):
    stocks[i] = stocks[i].strip()

with pd.ExcelWriter('multiple_stocks.xlsx', engine='openpyxl') as writer:
    # Per ogni azione, scarica i dati e salvali in un foglio separato
    for stock in stocks:
        # Scarica i dati storici dell'azione (ad esempio per l'ultimo anno)
        data = yf.download(stock, period='1mo')

        # Scrivi i dati in un foglio con il nome dell'azione
        data.to_excel(writer, sheet_name=stock)

    print("Dati salvati con successo in 'multiple_stocks.xlsx'")
