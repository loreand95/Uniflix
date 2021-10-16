import Carousel from '../components/Carousel';
import CategoryCards from '../components/CategoryCards';
import BaseLayout from './BaseLayout';

export default function HomePage(){
    return(
        <BaseLayout>
            <Carousel />
            <CategoryCards 
                categoryName='adventure'/>
            <CategoryCards 
                categoryName='drama'/>
        </BaseLayout>
    );
}
