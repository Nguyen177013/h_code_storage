import { createContext, useReducer, Dispatch } from "react";
import { initialState, dashboardReducer } from "./reducer";

type ContextType = {
  state: {
    years: datetimeSelectionType[];
    sauceHistory: SauceHistoryProp;
    total: TotalUpload;
  };
  dispatch: Dispatch<any>;
};
type Props = {
    children: React.ReactNode
}
export const DashboardContext = createContext<ContextType | null>(null);
const DashboardContextProvider = ({ children }: Props) =>{
    const [state, dispatch] = useReducer(dashboardReducer, initialState);
    return (
        <DashboardContext.Provider value={{state, dispatch}}>
            {children}
        </DashboardContext.Provider>
    )
}
export default DashboardContextProvider;