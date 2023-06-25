const { Header : AntHeader} = Layout;
import { Image, Layout,} from "antd"


const Header = () => {
    return (
        <Layout>
            <AntHeader style={{ display: 'flex', alignItems: 'center', backgroundColor: "#fff", padding: "0" }}>
                <div className="demo-logo" />
                <Image
                    width={200}
                    src="/img/image-8.png"
                    preview={false}
                />
                <h1>My Private Storage</h1>
            </AntHeader>
        </Layout>
    );
}

export default Header;