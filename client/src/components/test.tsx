import {Layout, Menu} from "antd"
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
                collapsed
            >

            </Sider>
        </Layout>
     );
}
 
export default SiderDemo;

