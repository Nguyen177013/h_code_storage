import { Col, Row, Select, Space } from "antd";
import { useEffect, useState } from "react";
import CountUp from "react-countup";
import MainDashBoard from "../features/dashboard/MainDashBoard";
import useDashboardContext from "../hooks/useDashboard";
import {
  getDashBoard,
  getYear,
  getTotal,
} from "../context/dashboard_context/action";
const HomePage = () => {
  const { state, dispatch } = useDashboardContext();
  const [date, setDate] = useState<dateOptionType>({ option: "", year: "" });
  useEffect(() => {
    getYear(dispatch);
    getTotal(dispatch);
  }, []);

  useEffect(() => {
    getDashBoard(date.year, date.option, dispatch);
  }, [date]);
  const handleChangeYear = (value: string) => {
    setDate((preDate) => ({
      ...preDate,
      year: value,
    }));
  };
  const handleChangeOptions = (value: string) => {
    setDate((preDate) => ({
      ...preDate,
      option: value,
    }));
  };
  return (
    <div>
      <Row gutter={[24, 0]}>
        <Col span={6}>
          <div>
            <div>
              <h4>
                {" "}
                Sauces have been add from today:{" "}
                <CountUp
                  end={state.total.totalUpload}
                  duration={3}
                ></CountUp>{" "}
              </h4>
            </div>
          </div>
        </Col>
        <Col span={18}>
          <Space wrap>
            <h4>Select Date Time For DashBoard</h4>
            <Select
              style={{ width: 120 }}
              onChange={handleChangeYear}
              options={state.years}
            />
            <Select
              defaultValue="year"
              style={{ width: 120 }}
              disabled={date.year === ""}
              onChange={handleChangeOptions}
              options={[
                {
                  value: "month",
                  label: "Month",
                },
                {
                  value: "year",
                  label: "Year",
                },
              ]}
            />
          </Space>
        </Col>
      </Row>
      <MainDashBoard {...state.sauceHistory} />
    </div>
  );
};

export default HomePage;
