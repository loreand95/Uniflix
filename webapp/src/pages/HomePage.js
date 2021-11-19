import React, { useEffect } from "react";
import Carousel from "../components/Carousel";
import CategoryCards from "../components/CategoryCards";
import BaseLayout from "./BaseLayout";
import { getMoviesByGenre } from "../api/rest/filmService";
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
    getMoviesByGenre(28).then((response) => {
      setFilm(response[0]);
    });
  }, []);

  return (
    <div style={{ display: match ? "block" : "none" }}>
      {isLoading && <WelcomeLoader />}
      <BaseLayout>
        <Carousel film={film} />
        <CategoryCards genreId={28} title="Adventure" />
      </BaseLayout>
    </div>
  );
}
