import { Col, Row } from "antd";
import axios from "axios";
import { useEffect, useState, useMemo } from "react";
import CountUp from 'react-countup';
import MainDashBoard from "../features/dashboard/MainDashBoard";

const HomePage = () => {
    const [sauceHistory, setSauceHistory] = useState<SauceHistory[]>([]);
    useEffect(() => {
        axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-history?year=2023&dateUpload=month",{
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Basic ${window.btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114")}`
            }
        })
        .then(response =>{
            const {data} = response;
            setSauceHistory(data);
        })
    }, [])
    const total : number[] = useMemo(()=>{
        return sauceHistory.map(data => data.total);
    },[sauceHistory]);
    const dateFormat : string[] = useMemo(()=>{
        return sauceHistory.map(data =>{ 
            const number = data.dateFormat;
            const monthName = new Intl.DateTimeFormat('en-US',{month:'short'}).format(new Date(0, number - 1));
            return monthName;
        });
    },[sauceHistory]);
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
            <MainDashBoard filterBy="month"  dateFormat={dateFormat} total={total}/>
        </div>
    );
}

export default HomePage;