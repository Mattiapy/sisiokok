import yfinance as yf
import pandas as pd
from openpyxl import Workbook
from openpyxl.chart import LineChart, Reference

# Carica la lista delle azioni dal file "lista.txt"

f = open("lista.txt", encoding='utf-8-sig')
stocks = f.readlines()
numero_righe = len(f.readlines())
active_stocks = []
print(stocks)
# Pulizia e selezione delle azioni attive
for i in range(0, len(stocks)):
    stocks[i] = stocks[i].strip()

for i in stocks:
    if str.__contains__(i, " x"):
        active_stocks.append(i)

for i in range(0, len(active_stocks)):
    active_stocks[i] = active_stocks[i].replace(" x", "")

# Crea il file Excel
with pd.ExcelWriter('multiple_stocks.xlsx', engine='openpyxl') as writer:
    # Aggiungi un foglio separato per i grafici
    workbook = writer.book
    chart_sheet = workbook.create_sheet("Grafici")

    # Inizializza una posizione per i grafici nel foglio "Grafici"
    start_row = 2  # Inizia a inserire i grafici dalla seconda riga (in modo da lasciare la prima per l'intestazione)

    for stock in active_stocks:
        # Scarica i dati storici
        data = yf.download(stock, period='6mo')

        # Scrivi i dati nel foglio Excel (un foglio per ogni azione)
        data.to_excel(writer, sheet_name=stock)

        # Aggiungi un grafico direttamente in Excel
        chart = LineChart()
        chart.title = f'{stock} - Prezzo chiusura (Ultimi 6 Mesi)'
        chart.style = 13  # Impostazione dello stile del grafico

        # Aggiungi i dati al grafico (dati di chiusura)
        worksheet = workbook[stock]
        data_range = Reference(worksheet, min_col=5, min_row=2, max_col=5, max_row=len(data)+1)  # Colonna 'Close'
        date_range = Reference(worksheet, min_col=1, min_row=2, max_row=len(data)+1)  # Colonna 'Date'
        chart.add_data(data_range, titles_from_data=True)
        chart.set_categories(date_range)

        # Posiziona il grafico nel foglio "Grafici"
        chart_location = f'B{start_row}'  # Imposta la posizione del grafico nella colonna B
        chart_sheet.add_chart(chart, chart_location)

        # Aumenta la posizione della riga per il prossimo grafico
        start_row += 15  # Sposta il grafico successivo più in basso per evitare sovrapposizioni

    print("Dati e grafici salvati con successo in 'multiple_stocks.xlsx'")
