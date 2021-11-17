import React, { useEffect } from "react";
import Carousel from "../components/Carousel";
import CategoryCards from "../components/CategoryCards";
import BaseLayout from "./BaseLayout";
import { getAllFilmByCategory } from "../api/rest/shopService";
import WelcomeLoader from "../components/welcomeLoader/WelcomeLoader";

export default function HomePage({ match }) {
  const [film, setFilm] = React.useState([]);
  const [isLoading, setLoading] = React.useState(true);

  //Loader X
  useEffect(() => {
    const timer = setTimeout(() => {
      setLoading(false);
    }, 3000);
    return () => clearTimeout(timer);
  }, []);

  //Retrieve movies
  useEffect(() => {
    getAllFilmByCategory("best").then((response) => {
      setFilm(response.data[0]);
    });
  }, []);

  return (
    <>
      {isLoading && <WelcomeLoader />}
      <BaseLayout style={{ display: match ? "block" : "none" }}>
        <Carousel film={film} />
        <CategoryCards categoryName="adventure" />
        <CategoryCards categoryName="drama" />
      </BaseLayout>
    </>
  );
}
