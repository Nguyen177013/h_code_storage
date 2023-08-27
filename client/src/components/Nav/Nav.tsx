import { Layout, Menu, MenuProps } from "antd";
import {
  HomeOutlined,
  FileImageOutlined,
  CodeOutlined,
  LoginOutlined
} from "@ant-design/icons";
import { useState } from "react";
const { Sider } = Layout;
import { useNavigate } from "react-router-dom";
const Nav = () => {
  const navigate = useNavigate();
  const [collapsed, setCollapsed] = useState<boolean>(false);
  const toggle = () => {
    setCollapsed((preCollapsed) => !preCollapsed);
  };
  const menuItems: MenuProps["items"] = [
    {
      label: "Home",
      icon: <HomeOutlined />,
      key: "home",
      onClick: () => {
        navigate("/");
      },
    },
    {
      label: "Images",
      icon: <FileImageOutlined />,
      key: "images",
      onClick: () => {
        navigate("/image");
      },
    },
    {
      label: "Nuke Code",
      icon: <CodeOutlined />,
      key: "code",
      onClick: () => {
        navigate("/sauce");
      },
    },
    {
      label: "Login",
      icon: <LoginOutlined />,
      key: "login",
      onClick: () => {
        navigate("/login");
      },
    },
  ];
  return (
    <Sider
      collapsed={collapsed}
      collapsible
      onCollapse={toggle}
      style={{
        padding: "10px 0",
        overflow: "auto",
        height: "calc(100vh - 64px)",
        position: "sticky",
        top: 0,
        left: 0,
      }}
    >
      <div className="logo" />
      <Menu
        theme="dark"
        mode="inline"
        defaultSelectedKeys={["home"]}
        items={menuItems}
      ></Menu>
    </Sider>
  );
};

export default Nav;
