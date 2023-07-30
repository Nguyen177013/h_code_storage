import { useContext } from "react";
import { DashboardContext } from "../context/dashboard_context/dashboardContext"
const useDashboardContext = () => {
    const context = useContext(DashboardContext);
    if (!context) {
        throw Error("useDashboard must be used inside an DashboardContextProvider");
    }
    return context;
}
export default useDashboardContext;