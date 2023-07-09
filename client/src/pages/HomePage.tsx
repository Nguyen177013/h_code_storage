import { Col, Row, Select, Space } from "antd";
import axios from "axios";
import { useEffect, useState, useMemo } from "react";
import CountUp from 'react-countup';
import MainDashBoard from "../features/dashboard/MainDashBoard";

const HomePage = () => {
    const [sauceHistory, setSauceHistory] = useState<SauceHistory[]>([]);
    useEffect(() => {
        axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-history?year=2023&dateUpload=day", {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Basic ${window.btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114")}`
            }
        })
            .then(response => {
                const { data } = response;
                setSauceHistory(data);
            })
    }, [])
    const total: number[] = useMemo(() => {
        return sauceHistory.map(data => data.total);
    }, [sauceHistory]);
    const dateFormat: string[] = useMemo(() => {
        return sauceHistory.map(data => {
            const number = data.dateFormat;
            const monthName = new Intl.DateTimeFormat('en-US', { month: 'short' }).format(new Date(0, number - 1));
            return monthName;
        });
    }, [sauceHistory]);
    const handleChange = (value : string) =>{
        console.log(value);
        
    }
    return (
        <div>
            <Row gutter={[24, 0]}>
                <Col span={6}>
                    <div>
                        <div>
                            <h4> Sauces have been add from today:  <CountUp end={100} duration={3}></CountUp> </h4>
                        </div>
                    </div>
                </Col>
                <Col span={18}>
                    <Space wrap>
                        <h4>Select Date Time For DashBoard</h4>
                        <Select
                            defaultValue={new Date().getFullYear().toString()}
                            style={{ width: 120 }}
                            onChange={handleChange}
                            options={[
                                { value: '2023', label: '2023' },
                                { value: '2022', label: '2022' },
                                { value: '2021', label: '2021' },
                            ]}
                        />
                        <Select
                            defaultValue="lucy"
                            style={{ width: 120 }}
                            disabled
                            options={[{ value: 'lucy', label: 'Lucy' }]}
                        />

                    </Space>
                </Col>
            </Row>
            <MainDashBoard filterBy="month" dateFormat={dateFormat} total={total} />
        </div>
    );
}

export default HomePage;