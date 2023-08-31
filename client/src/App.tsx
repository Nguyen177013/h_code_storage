import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "/public/css/index.css";
import HomeLayout from "./components/Layout/HomeLayout";
import HomePage from "./pages/HomePage";
import ImagePage from "./features/Images/ImagePage";
import NukeCodePage from "./features/SourceCode/NukeCodePage";
import LoginPage from "./features/authentication/LoginIndex";
import useAuthContext from "./hooks/userAuth";
function App() {
  const {state} = useAuthContext();
  const token = state.accessToken;
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={token ? <HomeLayout /> : <Navigate to={"/login"} />}
        >
          <Route index element={<HomePage />} />
          <Route path="image" element={<ImagePage />} />
          <Route path="sauce" element={<NukeCodePage />} />
        </Route>
        <Route
          path="login"
          element={token ? <Navigate to={"/"} /> : <LoginPage />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
