import { useState } from "react";
import useAuthContext from "../../hooks/useAuth";
import { login } from "../../context/auth_context/actions";
import { useNavigate  } from "react-router";

const LoginPage = () => {
  const navigate = useNavigate();
  const { dispatch } = useAuthContext();
  const [form, setInput] = useState<LoginType>({
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
  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    await login(dispatch, form);
  }
  return (
    <>
      <h1>Login page</h1>
      <form onSubmit={handleSubmit}>
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
        <button>login</button>
      </form>
      <p
        style={{ color: "#4285f4", cursor: "pointer" }}
        onClick={() => {
          navigate("/register");
        }}
      >
        register if don't have account
      </p>
    </>
  );
};

export default LoginPage;
