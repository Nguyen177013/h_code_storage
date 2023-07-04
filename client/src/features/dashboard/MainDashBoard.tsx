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
    };
    const labels = dateFormat;
    const dataset: datasetType = {
        backgroundColor: random_rgba(),
        borderColor: random_rgba(),
        data: total,
        label: `Contribution Line Chart of this ${filterBy}`
    };
    const data = {
        labels:labels,
        datasets: [
            dataset
        ]
    }
    return (
        <div>
            <Line options={options} data={data}/>
        </div>
    );
}

export default MainDashBoard;