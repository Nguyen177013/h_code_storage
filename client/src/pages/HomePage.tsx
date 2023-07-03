import { Col, Row } from "antd";
import axios from "axios";
import { useEffect } from "react";
import CountUp from 'react-countup';

const HomePage = () => {
    console.log(window.btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114"));
    useEffect(() => {
        axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-history?year=2023&dateUpload=month",{
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Basic ${window.btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114")}`
            }
        })
        .then(response =>{
            console.log(response);
        })
    }, [])
    return (
        <div>
            <h1>
                This is home page
            </h1>
            <Row gutter={[24, 0]}>
                <Col span={6}>
                    <div>
                        <div>
                            <h4> <CountUp end={100} duration={3}></CountUp> </h4>
                        </div>
                    </div>
                </Col>
            </Row>
        </div>
    );
}

export default HomePage;