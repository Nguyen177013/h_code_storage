import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import DashboardContextProvider from "./context/dashboard_context/dashboardContext.tsx";
import ImageContextProvider from "./context/images_context/imageContext.tsx";

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <ImageContextProvider>
      <DashboardContextProvider>
        <App />
      </DashboardContextProvider>
    </ImageContextProvider>
  </React.StrictMode>
);
