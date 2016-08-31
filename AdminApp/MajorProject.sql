-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 27, 2016 at 05:34 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MajorProject`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_Audio`
--

CREATE TABLE IF NOT EXISTS `tbl_Audio` (
  `audio_id` int(11) NOT NULL,
  `audio_bpm` double NOT NULL DEFAULT '0',
  `audio_dancebility` double NOT NULL DEFAULT '0',
  `audio_energy` double NOT NULL DEFAULT '0',
  `audio_loudness` double NOT NULL DEFAULT '0',
  `track_id` int(11) NOT NULL,
  `lyrics_valence` double DEFAULT '0',
  `lyrics_arousal` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_Audio`
--

INSERT INTO `tbl_Audio` (`audio_id`, `audio_bpm`, `audio_dancebility`, `audio_energy`, `audio_loudness`, `track_id`, `lyrics_valence`, `lyrics_arousal`) VALUES
(1, 0.0929703712, 0.3381829659, 0.4222432806, 0.5113347211, 1, 0.5745295699, 0.5548697917),
(2, 0.1815037251, 0.3773327669, 0.494854002, 0.5766859409, 2, 0.3856779116, 0.5387657717),
(3, 0.5348240852, 0.3223134875, 0.2015226779, 0.2876834481, 3, 0.2821438678, 0.28452959),
(4, 0.2497680187, 0.347726504, 0.4327740613, 0.5210076155, 4, 0.0994846171, 0.1491434731),
(5, 0.3312108994, 0.369593819, 0.5687036561, 0.640268212, 5, 0.0830989013, 0.105853814),
(6, 0.1063460827, 0.4044968685, 0.0995456892, 0.1625313314, 6, 0.8540185894, 0.9543644068),
(7, 0.5851439476, 0.3415405353, 0.2616444417, 0.3534325315, 7, 0.3597545334, 0.3877108051),
(8, 0.1683960438, 0.3261967699, 0.0326531868, 0.0642416221, 8, 0.3397555537, 0.4171309309),
(9, 0.1619582176, 0.4235417048, 0.316313414, 0.4096635999, 9, 0.1227565103, 0.1388735318),
(10, 0.2987072945, 0.3934335709, 0.5859616107, 0.6547585149, 10, 0.0882952386, 0.0890032115),
(11, 0.1241491795, 0.3206228614, 0.0336188179, 0.0658137593, 11, 0.0374027604, 0.0501805651),
(12, 0.156062746, 0.4195259015, 0.4810666996, 0.5645089775, 12, 0.6939665472, 0.7782304527),
(13, 0.3369904995, 0.4450120131, 0.0019255373, 0.0104666727, 13, 0.2753447238, 0.2973425849),
(14, 0.5746594429, 0.3886133035, 0.3136444417, 0.4069855058, 14, 0.0962283836, 0.1000789499),
(15, 0.363881588, 0.3684945901, 0.8462145257, 0.8597889254, 15, 0.0927475251, 0.0966181825),
(16, 0.3028641701, 0.3947337468, 0.223323246, 0.3120654297, 16, 0.0351111452, 0.0515797454),
(17, 0.1255201817, 0.4073944887, 0.0312868083, 0.0620068145, 17, 1.0442990465, 1.0441981132),
(18, 0.2421174526, 0.3857906262, 0.4210857213, 0.5102671412, 18, 0.3757129703, 0.3859297291),
(19, 0.3361559868, 0.365226984, 1.0010418972, 0.9723131682, 19, 0.2054111712, 0.2425972882),
(20, 0.1057400227, 0.3892178933, 0.2046129447, 0.2911806127, 20, 0.2137492473, 0.2604667712),
(21, 0.3118190289, 0.3119096557, 0.2037751729, 0.2902339467, 21, 0.6497147246, 0.8559183674),
(22, 0.2993824959, 0.5198147297, 0.2840419466, 0.3768331963, 22, 0.6905692541, 0.7017356215),
(23, 0.2504282951, 0.3747416337, 0.1048401927, 0.1696094607, 23, 0.3912840604, 0.4250791159),
(24, 0.3258483887, 0.4047992627, 0.3314387599, 0.424721337, 24, 0.5813620072, 0.6447777778),
(25, 0.5760640144, 0.3258211811, 0.4684534091, 0.553277438, 25, 0.5559666878, 0.5549189543),
(26, 0.2496762276, 0.439692378, 0.5126382905, 0.5922443805, 26, 0.100205053, 0.091275094),
(27, 0.0811201572, 0.317055583, 0.6997775198, 0.7472894394, 27, 0.1029252519, 0.1008534824),
(28, 0.3730876923, 0.3707627455, 0.4030202569, 0.4934924531, 28, 0.0463306901, 0.0453491456),
(29, 0.1553274632, 0.3214540084, 0.0319671257, 0.0631210381, 29, 0.6379822897, 0.5681617647),
(30, 0.5852116585, 0.3261339068, 0.5215828063, 0.6000080524, 30, 0.2050006875, 0.2982593777),
(31, 0.4625717163, 0.3847864866, 0.0175981781, 0.0388941286, 31, 0.3311752388, 0.3649648926),
(32, 0.1241130352, 0.4365300735, 0.1308600791, 0.2033120888, 32, 0.1094263544, 0.1393221721),
(33, 0.1236260891, 0.3229403893, 0.0542323617, 0.0980973736, 33, 0.0609238093, 0.0744675721),
(34, 0.3932547569, 0.3528805176, 0.4890621542, 0.5715830592, 34, 0.6684438471, 0.8087731482),
(35, 0.1495383263, 0.3379729986, 0.5058453063, 0.5863209293, 35, 0.2762131914, 0.2659463508),
(36, 0.347339201, 0.3298878471, 0.25155, 0.3427062346, 36, 0.1753747111, 0.1978660709),
(37, 0.4524887085, 0.4036517143, 0.2179941947, 0.3061662212, 37, 0.1123086882, 0.1153618094),
(38, 0.237466383, 0.4135919015, 0.2472558794, 0.338107696, 38, 0.0554564622, 0.0563423824),
(39, 0.1194448948, 0.3806590239, 0.4952943676, 0.5770731822, 39, 0.1069212507, 0.1078137535),
(40, 0.4921368599, 0.3171093464, 0.2392343379, 0.3294585218, 40, 0.5747143817, 0.8289322917),
(41, 0.1429042339, 0.3943523566, 0.5384995553, 0.614583162, 41, 0.2901835653, 0.3850231015),
(42, 0.5862057686, 0.3795716763, 0.4706985672, 0.5552831603, 42, 0.2253849767, 0.3358856573),
(43, 0.1030459881, 0.3894408147, 0.1926844368, 0.2776026247, 43, 0.2325763732, 0.2677408433),
(44, 0.1813231945, 0.3116879662, 0.0371715909, 0.0715479801, 44, 0.0663540515, 0.0530614254),
(45, 0.5872485161, 0.3123096625, 0.2527198123, 0.3439552495, 45, 0.0034838204, 0.0031201525),
(46, 0.3315470219, 0.4261528651, 0.2104171443, 0.297711717, 46, 0.6067253177, 0.6973333333),
(47, 0.1112334728, 0.3579167922, 0.3300954051, 0.4233920127, 47, 0.1993788803, 0.2569009009),
(48, 0.437454319, 0.3888634841, 0.2621393775, 0.3539554636, 48, 0.2702649844, 0.2910900565),
(49, 0.2485101223, 0.3327551881, 0.0597851532, 0.1064256099, 49, 0.0960340862, 0.091047344),
(50, 0.4375177383, 0.3073882063, 0.1528878706, 0.2306157055, 50, 0.4119977363, 0.5009210526),
(51, 0.3250295639, 0.3354662259, 0.0968404521, 0.1588831637, 51, 0.5349566397, 0.6105405057),
(52, 0.1552861214, 0.3815716505, 0.0414626976, 0.0783736808, 52, 0.1840039175, 0.1786534177),
(53, 0.3126560211, 0.4419546922, 0.2646358449, 0.3565891413, 53, 0.2469674566, 0.2577821417);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_Track`
--

CREATE TABLE IF NOT EXISTS `tbl_Track` (
  `track_id` int(11) NOT NULL,
  `track_title` varchar(25) NOT NULL,
  `track_source` varchar(250) NOT NULL,
  `track_stream_url` varchar(150) DEFAULT NULL,
  `track_album_art_url` varchar(300) DEFAULT NULL,
  `track_artist` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_Track`
--

INSERT INTO `tbl_Track` (`track_id`, `track_title`, `track_source`, `track_stream_url`, `track_album_art_url`, `track_artist`) VALUES
(1, 'Stay With Me', ',/Stay With Me.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/0a835a3924994306c3cfee7583c4de65.png', 'Sam Smith'),
(2, 'Heartbreak Warfare', './Heartbreak Warfare.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/07e68a1bd343a96dfb452b29a57dc223.png', 'John Mayer'),
(3, 'Hello', './Hello.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/4f086858dcab721983d443c597e02c0d.png', 'Adele'),
(4, 'Overlord', './Overlord.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/e0daf00153a8aba72826a355914cee93.png', 'Lamb of God'),
(5, 'Nymphetamine', './Nymphetamine.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/c1178c83f7e34519982f9081325581f2.png', 'Cradle of Filth'),
(6, 'Billionaire', './Billionaire.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/07c51c2d2bc34a1499afe714a271fc40.png', 'Travie McCoy'),
(7, 'Black Dog', './Black Dog.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/a9b30b1f754d4e7198ca1d5cdc469c9e.png', 'Led Zeppelin'),
(8, 'Californication', './Californication.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/4cd01160de7d464fc673cd8637bc3f35.png', 'Red Hot Chilli Peppers'),
(9, 'Blank Space', './Blank Space.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/dc0f31dfeef6def3758883106859343b.png', 'Taylor Swift'),
(10, 'Cheer Leader', './Cheer Leader.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/ad427a3a46d64b36d768eff16219ddaf.png', 'Omi'),
(11, 'Demons', ',/Demons.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/1e43ea142a9c4ad6bffebb00eaf7714a.png', 'Imagine Dragons'),
(12, 'Fancy ', ',/Fancy.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/6a2143df46a4656973ed4906025ad95c.png', 'Iggy Azalea'),
(13, 'Firework', './Firework.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/edf0aca9bbb0d500ee38276dbb9d4b61.png', 'Katy Perry'),
(14, 'Happy', './happy.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/89779c7a47b44598c56ff54c3bd9e7fd.png', 'Pharrell Williams'),
(15, 'I Can Only Imagine', './I Can Only Imagine.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/b3f9d8f065ef452fc552736905687cb5.png', 'David Guetta'),
(16, 'Iridescent', './Iridescent.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/742df950c2d64448b004fd225ed8b13f.png', 'Linkin Park'),
(17, 'Just A Dream', './Just A Dream.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/bd6a0a6f40484eea9a6e8af5b9510fee.png', 'Nelly'),
(18, 'Just The Way You Are', './Just The Way You Are.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/c7b01efc849fc8c6c1b0624a09c87a49.png', 'Bruno Mars'),
(19, 'Like A G6', './Like A G6.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/36f5b7d5a0574ea8b8679961f74b0ba7.png', 'Far East Movement'),
(20, 'Love The Way You Lie', './Love The Way You Lie.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/c071c18b6b4c40e7bbd9f1fd70ea5252.png', 'Eminem'),
(21, 'Wrecking Ball', './Wrecking Ball.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/db3ba81288887971bb92019e1537729c.png', 'Miley Cyrus'),
(22, 'Morning After Dark', './Morning After Dark.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/a35a4846ec2346a5b084af13ff447354.png', 'Timbaland'),
(23, 'Payphone', './Payphone.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/d10d8f85401f4eb08fcad3deaab7ac0a.png', 'Maroon 5'),
(24, 'Rather Be', './Rather Be.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/b5c8ede9e9cc41a3c1d1abafe3d1d662.png', 'Clean Bandit'),
(25, 'See You Again', './See You Again.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/e434c1dd75b54d1bbbec0d4766521a4c.png', 'Wiz Khalifa'),
(26, 'Shadow Of The Day', './Shadow Of The Day.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/742df950c2d64448b004fd225ed8b13f.png', 'Linkin Park'),
(27, 'The Reason', './The Reason.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/b5ef1be4318d4d4a946aa20f0f49b723.png', 'Hoobastank'),
(28, 'You Belong With Me', './You Belong With Me.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/4cd01160de7d464fc673cd8637bc3f35.png', 'Taylor Swift'),
(29, 'World Behind My Wall', './World Behind My Wall.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/7f62c21dff1a430cc32c3a150cf6d41d.png', 'Tokio Hotel'),
(30, '21 Guns', './21 Guns.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/67c10230f08349c08c24bc5093167b3a.png', 'Green Day'),
(31, 'Rockstar', './Rockstar.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/0d0999e04adb49e984a33f6a2e1fe4e0.png', 'Nickelback'),
(32, 'Cheap Thrills', './Cheap Thrills.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/ee10f625b9a87a4d5d6febca8b0746a9.png', 'Sia'),
(33, 'Roar', './Roar.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/edf0aca9bbb0d500ee38276dbb9d4b61.png', 'Katy Perry'),
(34, 'Edge Of Desire', './Edge Of Desire.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/07e68a1bd343a96dfb452b29a57dc223.png', 'John Mayer'),
(35, 'Wake Up', './Wake Up.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/d2481543520de84a0fed48e688c68d66.png', 'The Vamps'),
(36, 'All Of Me', './All Of me.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/0c8d1b89661c4bcf9d539eb84427fd7f.png', 'John Legend'),
(37, 'Stop Standing There', './Stop Standing There.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/73641cc8639c40a097dd45dd67e98d3b.png', 'Avril Lavigne'),
(38, 'Photograph', './Photograph.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/3329123a8f4375a3d8534ae29246ae51.png', 'Ed Sheeran'),
(39, 'Good For You', './Good For You.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/c2d408c8a4cb7c14db639518fe17a8ef.png', 'Selena Gomez'),
(40, 'My Immortal', './My Immortal.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/8df632e19cba464599d82827875c1fc4.png', 'Evanescence'),
(41, 'American Idiot', './American Idiot.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/67c10230f08349c08c24bc5093167b3a.png', 'Green Day'),
(42, 'Darling', './Darling.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/6e45e0535f6142989acef401e626f792.png', 'Eyes Set to Kill'),
(43, 'Misery Business', './Misery Business.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/a05b64fa0ea8482fc84b16d82308be51.png', 'Paramore'),
(44, 'Pieces', './Pieces.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/d4cee9d79c0c4559c539a859482175ab.png', 'Sum 41'),
(45, 'Empty', './Empty.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/769beb55947f4b629cb21fb02f1beee7.png', 'The Click Five'),
(46, 'Anything But Ordinary', './Anything But Ordinary.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/73641cc8639c40a097dd45dd67e98d3b.png', 'Avril Lavigne'),
(47, 'It''s Not Over', './It''s Not Over', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/ea8c38a4a80643949461d53a7d86f30c.png', 'Secondhand Serenade'),
(48, 'Wildest Dreams', './Wildest Dreams.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/4cd01160de7d464fc673cd8637bc3f35.png', 'Taylor Swift'),
(49, 'Little Things', './Little Things.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/2b9f19e98a348342f59449a3b8b32481.png', 'One Direction'),
(50, 'Dare You To Move ', './Dare You To Move', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/181914956a584663a96d665df3089b6f.png', 'Switchfoot'),
(51, 'I Really Want You', './I Really Want You.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/ab56bc6a6d35408b871fe900916dab15.png', 'James Blunt'),
(52, 'Wonderful Tonight', './Wonderful Tonight.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/15fe26485bc54344bb43d7d05705c46d.png', 'Eric Clapton'),
(53, 'Sugar', './Sugar.mp3', 'http://192.168.1.101:8081/listen/', 'https://lastfm-img2.akamaized.net/i/u/300x300/d10d8f85401f4eb08fcad3deaab7ac0a.png', 'Maroon 5');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_Track_Log`
--

CREATE TABLE IF NOT EXISTS `tbl_Track_Log` (
  `Teen` int(11) NOT NULL,
  `Young Adult` int(11) NOT NULL,
  `Adult` int(11) NOT NULL,
  `Kathmandu` int(11) NOT NULL,
  `Bhaktapur` int(11) NOT NULL,
  `Lalitpur` int(11) NOT NULL,
  `track_id` int(11) NOT NULL,
  `log_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_Track_Log`
--

INSERT INTO `tbl_Track_Log` (`Teen`, `Young Adult`, `Adult`, `Kathmandu`, `Bhaktapur`, `Lalitpur`, `track_id`, `log_id`) VALUES
(30, 20, 15, 28, 20, 17, 16, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_Audio`
--
ALTER TABLE `tbl_Audio`
  ADD PRIMARY KEY (`audio_id`),
  ADD KEY `track_id` (`track_id`);

--
-- Indexes for table `tbl_Track`
--
ALTER TABLE `tbl_Track`
  ADD PRIMARY KEY (`track_id`);

--
-- Indexes for table `tbl_Track_Log`
--
ALTER TABLE `tbl_Track_Log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `track_id` (`track_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_Audio`
--
ALTER TABLE `tbl_Audio`
  ADD CONSTRAINT `tbl_Audio_ibfk_1` FOREIGN KEY (`track_id`) REFERENCES `tbl_Track` (`track_id`);

--
-- Constraints for table `tbl_Track_Log`
--
ALTER TABLE `tbl_Track_Log`
  ADD CONSTRAINT `tbl_Track_Log_ibfk_1` FOREIGN KEY (`track_id`) REFERENCES `tbl_Track` (`track_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
