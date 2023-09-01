import { useState } from "react";
import useAuthContext from "../../hooks/useAuth";
import { register } from "../../context/auth_context/actions";
import { useNavigate } from "react-router";
const RegisterPage = () => {
  const navigate = useNavigate();
  const { dispatch } = useAuthContext();
  const [form, setInput] = useState<RegisterType>({
    password: "",
    userName: "",
    email: "",
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
    await register(dispatch, form);
  }
  return (
    <>
      <h1>Register page</h1>
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
        <input
          type="text"
          placeholder="email..."
          name="email"
          onChange={handleChange}
        />
        <button>register</button>
      </form>
      <p
        style={{ color: "#4285f4", cursor: "pointer" }}
        onClick={() => {
          navigate("/login");
        }}
      >
        login if have account
      </p>
    </>
  );
};

export default RegisterPage;
