import {Layout, Menu} from "antd"
import {SmileOutlined} from "@ant-design/icons"
import { useState } from "react";
const {Header, Sider, Content} = Layout;

const SiderDemo = () => {
    const [collapsed, setCollapsed] =useState<boolean>(false);
    const toggle = () =>{
        setCollapsed(preCollapsed=> !preCollapsed);
    }
    return ( 
        <Layout>
            <Sider
                trigger = {null}
                collapsed = {collapsed}
                collapsible
            >
                <div className="logo"/>
                    <Menu
                        theme="dark" mode="inline" defaultSelectedKeys={['1']}
                    >
                        <Menu.Item key={1}>
                            <SmileOutlined type="user"/>
                            <span>nav 1</span>
                        </Menu.Item>
                        <Menu.Item key={2}>
                            <SmileOutlined type="video-camera"/>
                            <span>nav 2</span>
                        </Menu.Item>
                        <Menu.Item key={3}>
                            <SmileOutlined type="upload"/>
                            <span>nav 3</span>
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
     );
}
 
export default SiderDemo;

