import React, { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { ThemeProvider, createTheme } from '@mui/material';
import Home from './screens/Home';
import Categories from './screens/Categories';
import Cart from './screens/Cart';
import BottomNavigation from './components/BottomNavigation';

const theme = createTheme({
  palette: {
    primary: {
      main: '#795548',
    },
    secondary: {
      main: '#4CAF50',
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <div className="app">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/categories" element={<Categories />} />
            <Route path="/cart" element={<Cart />} />
          </Routes>
          <BottomNavigation />
        </div>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App; 