import { Component } from 'react';
import { FaGithub, FaInstagram, FaLinkedinIn } from 'react-icons/fa';
import '../styles/components/SocialNetwork.sass';
import { ItensView as SocialItem } from '../types/ItensView';

const socialNetwork: SocialItem[] = [
     {nameKey: 'linkedin', icon: <FaLinkedinIn />, ref: 'https://www.linkedin.com/in/vitor-palhano'},
     {nameKey: 'github', icon: <FaGithub />, ref: 'https://github.com/p4lhano'},
     {nameKey: 'instagram', icon: <FaInstagram />, ref: 'https://www.instagram.com/p4lhano'}
]

export default class SocialNetwork extends Component {
    render() {
        return (
            <section id="social-network">
                {socialNetwork.map(
                    net => <a href={net.ref} className='social-btn' id={net.nameKey} key={net.nameKey}>{net.icon}</a>
                )}
            </section>
        )
    }
}
