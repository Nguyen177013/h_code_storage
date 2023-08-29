import { createContext, useReducer, Dispatch } from "react";
import { authenticateReducer, initialState } from "./reducer";

type ContextType = {
  state: AuthenticationType
  dispatch: Dispatch<any>;
};
type Props = {
    children: React.ReactNode
}

export const AuthContex = createContext<ContextType | null>(null);
const AuthProvider = ({children} : Props) =>{
    const [state, dispatch] = useReducer(authenticateReducer, initialState);
    return (
        <AuthContex.Provider value={{state, dispatch}}>
            {children}
        </AuthContex.Provider>
    )
}
export default AuthProvider;