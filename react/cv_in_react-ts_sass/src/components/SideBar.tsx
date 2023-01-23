import { Component } from 'react'
import '../styles/components/SideBar.sass'
import Informations from './Informations'
import SocialNetwork from './SocialNetwork'

export default class SideBar extends Component {
  render() {
    return (
        <aside id="sidebar">
            <img src="https://avatars.githubusercontent.com/u/72114099?v=4" alt="Avatar" />
            <p>imgem</p>
            <p className='title'>Desenvolvedor</p>
            <SocialNetwork />
            <Informations />
            <a href="#" className='btn'>Curiculo PDF</a>
        </aside>
    )
  }
}
