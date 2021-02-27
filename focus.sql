-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  sam. 27 fév. 2021 à 11:00
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `focus`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `texte` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `user_id`, `texte`, `date`) VALUES
(5, 2, 'bonne application', '2021-02-26');

-- --------------------------------------------------------

--
-- Structure de la table `emploi_du_temps`
--

CREATE TABLE `emploi_du_temps` (
  `horaire_debut` time NOT NULL,
  `titre` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `horaire_fin` time NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `emploi_du_temps`
--

INSERT INTO `emploi_du_temps` (`horaire_debut`, `titre`, `status`, `description`, `id_utilisateur`, `horaire_fin`, `id`) VALUES
('12:00:00', 'preparer du tiep', 'achevée', 'je vais preparer du tiep', 2, '16:00:22', 2),
('03:30:00', 'visionner les cameras', 'achevée', 'voir les ralentis des videos de surveillance', 2, '08:00:00', 3),
('20:00:00', 'vider les poubelles', 'inachevée', 'vider les poubelles de l\'entrepot', 2, '20:05:00', 4),
('12:00:22', 'rendre le projet java', 'achevée', 'rendre le projet au prof', 2, '19:00:00', 5),
('16:00:00', 'courses', 'achevée', 'aller faire les courses', 2, '17:00:00', 6),
('19:00:00', 'mise a jour', 'achevée', 'faire des mises a jour', 2, '20:00:00', 8),
('16:00:00', 'reunion', 'inachevée', 'finaliser le projet', 2, '17:00:00', 9),
('14:00:00', 'projet', 'achevée', 'rendre le projet', 3, '16:00:00', 10),
('15:00:00', 'manger', 'achevée', 'desr', 3, '17:00:00', 11);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `titre` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`titre`, `description`, `date`, `heure`, `id_utilisateur`, `id`) VALUES
('rencontre crutiale', 'une entrevue avec des responsables etudiants', '2021-02-22', '12:00:00', 2, 5),
('compte rendu', 'de', '2021-02-26', '16:30:00', 2, 8),
('sortie pedagogique', 'visiter un musée', '2021-02-26', '10:00:00', 2, 12),
('reunion', 'rendre le projet', '2021-02-26', '12:00:00', 2, 13),
('reunion', 'rendre le projet', '2021-02-20', '08:00:00', 2, 14),
('reunion', 'rendre le projet', '2021-02-27', '10:00:00', 3, 15);

-- --------------------------------------------------------

--
-- Structure de la table `infosdujour`
--

CREATE TABLE `infosdujour` (
  `id` int(11) NOT NULL,
  `information` text COLLATE utf8mb4_general_ci NOT NULL,
  `jour` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `infosdujour`
--

INSERT INTO `infosdujour` (`id`, `information`, `jour`, `user_id`) VALUES
(6, 'L\'anniversaire de mon pere', '2021-02-20', 2),
(7, 'rendre le projet de java', '2021-02-26', 2),
(8, 'debut du second semestre', '2021-03-07', 2),
(9, 'premier jour du mois', '2021-03-01', 2),
(10, 'fin du premier semestre', '2021-03-07', 2);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `identifiant` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`identifiant`, `password`, `email`, `age`, `id`, `date_creation`) VALUES
('ayrton', 'personofinterest', 'ayrtongonsallo@gmail.com', 20, 1, '2021-02-13'),
('marc', 'marc', 'mar@gmail.com', 20, 2, '2021-02-17'),
('marco', 'ma', 'marco@gmail.com', 22, 3, '2021-02-26');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `emploi_du_temps`
--
ALTER TABLE `emploi_du_temps`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `infosdujour`
--
ALTER TABLE `infosdujour`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `emploi_du_temps`
--
ALTER TABLE `emploi_du_temps`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `infosdujour`
--
ALTER TABLE `infosdujour`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
