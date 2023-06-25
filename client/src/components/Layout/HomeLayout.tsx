import Header from "../Header/Header";
import Nav from "../Nav/Nav";
import {Outlet} from 'react-router-dom'
const HomeLayout = () => {
    return (
        <>
            <Header />
            <Nav />
            <Outlet/>
        </>
    );
}

export default HomeLayout;