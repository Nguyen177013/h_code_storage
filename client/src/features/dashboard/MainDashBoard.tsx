import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import { Line } from 'react-chartjs-2';
import { random_rgba } from '../../utils/StringRgpUtil';
import "../../assets/chart.css"
import { Select, Space } from 'antd';
ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

const MainDashBoard = ({ dateFormat, total, filterBy }: SauceHistoryProp) => {
    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top' as const,
            },
            title: {
                display: true,
                text: `Contribution Line Chart By ${filterBy}`,
            },
        },
        maintainAspectRatio: false
    };
    const labels = dateFormat;
    const dataset: datasetType = {
        backgroundColor: random_rgba(),
        borderColor: random_rgba(),
        data: total,
        label: `Contribution Line Chart of this ${filterBy}`
    };
    const data = {
        labels: labels,
        datasets: [
            dataset
        ]
    }
    const handleChange = (value: string) => {
        console.log(value);

    }
    return (
        <div>
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
            <Line options={options} data={data} width={"100%"} />
        </div>
    );
}

export default MainDashBoard;