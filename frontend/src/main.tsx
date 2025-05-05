import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./styles/global.css";
import { Home } from "./containers/home/home";
import { Navbar } from "./components/navbar/navbar";
import AdminPanel from "./containers/admin/admin";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/admin" element={<AdminPanel />} />
      </Routes>
    </Router>
  </StrictMode>
);
