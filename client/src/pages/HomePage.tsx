import { Col, Row } from "antd";
import axios from "axios";
import { useEffect } from "react";
import CountUp from 'react-countup';

const HomePage = () => {
    let header = new Headers();
    header.append('Authorization', 'Basic '+ btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114"))
    console.log(header);
    
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
        fetch("http://localhost:8080/hentaibu/api/author"
        ,{
            method:"GET",
            headers:header
    })
    // .then(req => req.json())
    // .then(res =>{
    //     console.log(res);
    // })
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