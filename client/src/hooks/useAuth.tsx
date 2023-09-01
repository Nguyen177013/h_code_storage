import { useContext } from "react";
import { AuthContex } from "../context/auth_context/authContext";
const useAuthContext = () => {
    const context = useContext(AuthContex);
    if (!context) {
        throw Error("useDashboard must be used inside an DashboardContextProvider");
    }
    return context;
}
export default useAuthContext;