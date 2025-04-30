const { app, BrowserWindow, screen } = require('electron');

const createWindow = () => {
    const { width, height } = screen.getPrimaryDisplay().workAreaSize;

    const win = new BrowserWindow({
        width: Math.floor(width * 0.8),
        height: Math.floor(height * 0.8),
        resizable: true,
        minWidth: 800,
        minHeight: 600,
        autoHideMenuBar: true,
        // webPreferences
    });

    // Load the React dev server
    win.loadURL('http://localhost:3000');

    // Center window after it's been created and loaded
    win.once('ready-to-show', () => {
        win.center();
        win.show();
    });
};

app.whenReady().then(createWindow);

app.on('window-all-closed', () => {
    app.quit();
});