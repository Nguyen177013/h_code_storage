import { Col, Row } from "antd";
import axios from "axios";
import { useEffect } from "react";
import CountUp from 'react-countup';

const HomePage = () => {
    useEffect(()=>{
        // axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-history?year=2023&dateUpload=month",{
        //     headers:{
        //         "Content-Type":"application/json",
        //         Authorization:"Basic aGVudGFpYnU6NTA3YzZlMzRiNzdiNTkxNmMzYjc5MWUyZmY2MjcxMTQ="
        //     }
        // })
        // .then(response =>{
        //     console.log(response);
        // })
        fetch("http://localhost:8080/hentaibu/api/sauce-history/get-history?year=2023&dateUpload=month",{
            method:"GET",
            headers:{
                "content-type": "application/json",
                "Authorization":"Basic aGVudGFpYnU6NTA3YzZlMzRiNzdiNTkxNmMzYjc5MWUyZmY2MjcxMTQ="
            }
    })
    },[])
    return (
        <div>
            <h1>
                This is home page
            </h1>
            <Row gutter={[24,0]}>
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