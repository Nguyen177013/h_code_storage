import { Col, Row } from "antd";

const HomePage = () => {
    return (
        <div>
            <h1>
                This is home page
            </h1>
            <Row gutter={[24,0]}>
                <Col span={6}>
                    <div>
                        <div>
                            <h4> </h4>
                        </div>
                    </div>
                </Col>
            </Row>
        </div>
    );
}

export default HomePage;