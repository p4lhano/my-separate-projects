type TweetProps = {
    name: string
}

export function Tweet(props: TweetProps){
    return <h1>Tweet {props.name}</h1>;
}