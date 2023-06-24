import { Image, Layout, Menu } from "antd"
import { SmileOutlined } from "@ant-design/icons"
import { useState } from "react";
const { Header, Sider, Content } = Layout;
import "./assets/css/index.css"
function App() {
  const [collapsed, setCollapsed] = useState<boolean>(false);
  const toggle = () => {
    setCollapsed(preCollapsed => !preCollapsed);
  }
  return (
    <>
      <Layout>
        <Header style={{ display: 'flex', alignItems: 'center' }}>
          <div className="demo-logo" />
          <Menu
            theme="dark"
            mode="horizontal"            
          />
          <Image
          width={200}
          src="./assets/img/image-8.png"
          preview = {false}
          />
        </Header>
      </Layout>
      <Layout>
        <Sider
          trigger={null}
          collapsed={collapsed}
          collapsible
        >
          <div className="logo" />
          <Menu
            theme="dark" mode="inline" defaultSelectedKeys={['1']}
          >
            <Menu.ItemGroup>

            </Menu.ItemGroup>
            <Menu.Item key={1}>
              <span>Home</span>
            </Menu.Item>
            <Menu.Item key={2}>
              <SmileOutlined type="video-camera" />
              <span>Image</span>
            </Menu.Item>
            <Menu.Item key={3}>
              <SmileOutlined type="upload" />
              <span>Source</span>
            </Menu.Item>
          </Menu>
        </Sider>
        <Layout>
          <Header style={{ background: '#fff', padding: 0 }}>
            <SmileOutlined
              className="trigger"
              type={collapsed ? 'menu-unfold' : 'menu-fold'}
              onClick={toggle}
            />
          </Header>
          <Content style={{ margin: '24px 16px', padding: 24, background: '#fff', minHeight: 280 }}>
            Content
          </Content>
        </Layout>
      </Layout>
    </>
  )
}

export default App
