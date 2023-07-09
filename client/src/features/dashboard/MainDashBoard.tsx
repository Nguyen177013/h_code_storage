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
    return (
        <div>
            <Line options={options} data={data} width={"100%"} style={{marginTop:"38px"}} />
        </div>
    );
}

export default MainDashBoard;