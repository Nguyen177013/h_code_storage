import axios from "axios";
import { useState } from "react";
import { base_url } from "../../context";
import { headers } from "../../api/headerCommon";

type inputType = {
  userName: string;
  password: string;
};
type responseType = {
  accessToken: string;
  refreshToken: string;
  message: string;
};
const LoginPage = () => {
  const [input, setInput] = useState<inputType>({
    password: "",
    userName: "",
  });
  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    const name = e.target.name;
    const value = e.target.value;
    setInput((preInput) => ({
      ...preInput,
      [name]: value,
    }));
  }
  function handleSubmit() {
    console.log("hi");

    axios
      .post(`${base_url}auth/login`, input, {
        headers: headers.jsonApplication,
      })
      .then((res) => {
        const data: responseType = res.data;
        if (data.accessToken && data.refreshToken) {
          return localStorage.setItem("token", data.accessToken);
        }
        alert(data.message);
      });
  }
  return (
    <>
      <h1>Login page</h1>
      <input
        type="text"
        placeholder="user name..."
        name="userName"
        onChange={handleChange}
      />
      <input
        type="text"
        placeholder="password..."
        name="password"
        onChange={handleChange}
      />
      <button onClick={() => handleSubmit()}>login</button>
    </>
  );
};

export default LoginPage;
