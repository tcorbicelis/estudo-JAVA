import webview

webview.create_window(
    "Sistema de Clientes",
    "frontend/index.html",
    width=1000,
    height=700
)

webview.start()