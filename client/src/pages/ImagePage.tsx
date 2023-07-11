import type { CollapseProps } from 'antd';
import { Collapse } from 'antd';
import NukeCodePage from './NukeCodePage';

const text = `
A dog is a type of domesticated animal.
Known for its loyalty and faithfulness,
it can be found as a welcome guest in many households across the world.
`;

const items: CollapseProps['items'] = [
{
key: '1',
label: 'This is panel header 1',
children: <NukeCodePage/>,
},
{
key: '2',
label: 'This is panel header 2',
children: <NukeCodePage/>,
},
{
key: '3',
label: 'This is panel header 3',
children: <p>{text}</p>,
},
];
const ImagePage = () => {
    return ( 
        <>
            <Collapse items={items} />
            <img src="" alt="image" />
        </>
     );
}
 
export default ImagePage;