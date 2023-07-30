import { createContext, useReducer, useEffect, Dispatch } from "react";
import { ImageReducer, initialState } from "./reducer";

type ContextType = {
  state: ImageResponse[];
  dispatch: Dispatch<any>;
};
type Props = {
  children: React.ReactNode;
};
export const DashboardContext = createContext<ContextType | null>(null);

