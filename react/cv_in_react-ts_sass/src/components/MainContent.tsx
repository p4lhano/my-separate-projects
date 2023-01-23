import { Component } from 'react'
import '../styles/components/MainContent.sass'
import AboutContainer from './AboutContainer'
import ProjectsContainer from './ProjectsContainer'
import TechnologiesContainer from './TechnologiesContainer'

export default class MainContent extends Component {
  render() {
    return (
        <main id="main-contenct">
            <AboutContainer />
            <TechnologiesContainer />
            <ProjectsContainer />
        </main>
    )
  }
}
