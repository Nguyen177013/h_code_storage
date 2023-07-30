import { createContext, useReducer, Dispatch } from "react";
import { imageReducer, initialState } from "./reducer";

type ContextType = {
  state: ImageResponse[];
  dispatch: Dispatch<any>;
};
type Props = {
  children: React.ReactNode;
};
export const ImageContext = createContext<ContextType | null>(null);
const ImageContextProvider = ({ children }: Props) => {
  const [state, dispatch] = useReducer(imageReducer, initialState);
  return (
    <ImageContext.Provider value={{ state, dispatch }}>
      {children}
    </ImageContext.Provider>
  );
};
export default ImageContextProvider;
