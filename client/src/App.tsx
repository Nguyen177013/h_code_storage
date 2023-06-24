import { Image, Layout, Menu, MenuProps } from "antd"
import { HomeOutlined, FileImageOutlined, CodeOutlined } from "@ant-design/icons"
import { useState } from "react";
const { Header, Sider, Content } = Layout;
import "../public/css/index.css"
function App() {
  const [collapsed, setCollapsed] = useState<boolean>(false);
  const toggle = () => {
    setCollapsed(preCollapsed => !preCollapsed);
  }
  const menuItems: MenuProps['items'] = [
    {
      label:"Home",
      icon: <HomeOutlined/>,
      key:"home"
    },
    {
      label:"Images",
      icon: <FileImageOutlined/>,
      key:"images"
    },
    {
      label:"Nuke Code",
      icon: <CodeOutlined/>,
      key:"code"
    }
  ];
  return (
    <>
      <Layout>
        <Header style={{ display: 'flex', alignItems: 'center', backgroundColor:"#fff", padding:"0" }}>
          <div className="demo-logo" />
            <Image
              width={200}
              src="/img/image-8.png"
              preview={false}
            />
          <h1 style={{}}>My Private Storage</h1>
        </Header>
      </Layout>
      <Layout>
        <Sider
          trigger={null}
          collapsed={collapsed}
          collapsible
          style={{
            padding:"10px 0",
            overflow: "auto",
            height: "calc(100vh - 64px)",
            position: "sticky",
            top: 0,
            left: 0
          }}
        >
          <div className="logo" />
          <Menu
            theme="dark" mode="inline" defaultSelectedKeys={['1']}
            items={menuItems}
          >
          </Menu>
        </Sider>
        <Layout>
          {/* <Header style={{ background: '#fff', padding: 0 }}>
            <HomeOutlined
              className="trigger"
              type={collapsed ? 'menu-unfold' : 'menu-fold'}
              onClick={toggle}
            />
          </Header> */}
          <Content style={{ margin: '24px 16px', padding: 24, background: '#fff', minHeight: 280 }}>
          </Content>
        </Layout>
      </Layout>
    </>
  )
}

export default App
