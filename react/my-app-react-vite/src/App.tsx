import { useState } from "react";
import { AppRoutes } from "./AppRoutes";

function App() {
  const [tweets, setTweets] = useState<string[]>(['T1','T2']);

  function createTweet(){
    setTweets([...tweets,`T${tweets.length + 1}`]);
  }

  return (
    <>
      <AppRoutes />
      {/* {tweets.map(t => {
        return <Tweet name={t} />
      })}

      <button
      onClick={createTweet}
      style={{ // CSS in JS
        backgroundColor: '#000',
        color: '#FFF'
      }}
      >Add</button> */}
    </>
  );
}

export default App
