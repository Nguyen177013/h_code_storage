import { Breadcrumb, Layout } from "antd";
import Header from "../Header/Header";
import Nav from "../Nav/Nav";
import { Outlet } from 'react-router-dom'
import { Content } from "antd/es/layout/layout";
const HomeLayout = () => {
    return (
        <>
            <Header />
            <Layout>
                <Nav />
                <Layout>
                    <Content style={{ padding: 24, background: '#fff', minHeight: 280 }}>
                        <Outlet></Outlet>
                    </Content>
                </Layout>
            </Layout>
        </>
    );
}

export default HomeLayout;