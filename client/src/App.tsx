import { BrowserRouter, Routes, Route } from "react-router-dom"
import "/public/css/index.css"
import HomeLayout from "./components/Layout/HomeLayout"
import HomePage from "./pages/HomePage"
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeLayout />}>
          <Route index element={<HomePage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
