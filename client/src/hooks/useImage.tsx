import { useContext } from "react";
import { ImageContext } from "../context/images_context/imageContext";
const useImageContext = () => {
    const context = useContext(ImageContext);
    if (!context) {
        throw Error("useDashboard must be used inside an DashboardContextProvider");
    }
    return context;
}
export default useImageContext;