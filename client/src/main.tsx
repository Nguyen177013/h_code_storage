import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import DashboardContextProvider from "./context/dashboard_context/dashboardContext.tsx";
import ImageContextProvider from "./context/images_context/imageContext.tsx";
import AuthProvider from "./context/auth_context/authContext.tsx";

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <AuthProvider>
      <ImageContextProvider>
        <DashboardContextProvider>
          <App />
        </DashboardContextProvider>
      </ImageContextProvider>
    </AuthProvider>
  </React.StrictMode>
);
