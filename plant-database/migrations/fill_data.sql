/*
 * Filename: fill_data.sql
 * Description: Fills the ''plants'' database with data about plants
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

/* -- GENUS -- */
INSERT INTO genus(name) VALUES ('monsteras');
INSERT INTO genus(name) VALUES ('calatheas');
INSERT INTO genus(name) VALUES ('radiator plants');
INSERT INTO genus(name) VALUES ('lilies');
INSERT INTO genus(name) VALUES ('prickly pear');
INSERT INTO genus(name) VALUES ('tongavines');
INSERT INTO genus(name) VALUES ('roses');
INSERT INTO genus(name) VALUES ('mums');
INSERT INTO genus(name) VALUES ('west indian jasmine');
INSERT INTO genus(name) VALUES ('climbing cacti');

/* -- CLASS -- */
INSERT INTO class(name) VALUES ('monocotyledons');
INSERT INTO class(name) VALUES ('dicotyledons');

/* -- ORDER -- */
INSERT INTO plant_order(name) VALUES ('water plantains and allies');
INSERT INTO plant_order(name) VALUES ('gingers, bananas and allies');
INSERT INTO plant_order(name) VALUES ('pepper plants, birthwords and allies');
INSERT INTO plant_order(name) VALUES ('lilies, supplejacks and allies');
INSERT INTO plant_order(name) VALUES ('pinks, cacti and allies');
INSERT INTO plant_order(name) VALUES ('roses, elms, figs and allies');
INSERT INTO plant_order(name) VALUES ('asters bellflowers fanflowers and allies');
INSERT INTO plant_order(name) VALUES ('gentians, dogbanes, madders and allies');

/* -- FAMILY -- */
INSERT INTO family(name) VALUES ('arum');
INSERT INTO family(name) VALUES ('arrowroot');
INSERT INTO family(name) VALUES ('pepper');
INSERT INTO family(name) VALUES ('lily');
INSERT INTO family(name) VALUES ('cactuses');
INSERT INTO family(name) VALUES ('rose');
INSERT INTO family(name) VALUES ('daisy');
INSERT INTO family(name) VALUES ('madder');

/* -- PHYLUM -- */
INSERT INTO phylum(name) VALUES ('vascular plants');

/* -- LIFESPAN -- */
INSERT INTO lifespan(name) VALUES ('perennial');
INSERT INTO lifespan(name) VALUES ('annual');

/* -- PLANT PART -- */
INSERT INTO plant_part(name) VALUES ('flower');
INSERT INTO plant_part(name) VALUES ('leaf');
INSERT INTO plant_part(name) VALUES ('fruit');
INSERT INTO plant_part(name) VALUES ('stem');

/* -- COLOR -- */
INSERT INTO color(name) VALUES ('white');
INSERT INTO color(name) VALUES ('cream');
INSERT INTO color(name) VALUES ('green');
INSERT INTO color(name) VALUES ('pink');
INSERT INTO color(name) VALUES ('yellow');
INSERT INTO color(name) VALUES ('red');
INSERT INTO color(name) VALUES ('orange');
INSERT INTO color(name) VALUES ('burgundy');
INSERT INTO color(name) VALUES ('lavender');
INSERT INTO color(name) VALUES ('silver');
INSERT INTO color(name) VALUES ('gold');
INSERT INTO color(name) VALUES ('purple');
INSERT INTO color(name) VALUES ('tan');
INSERT INTO color(name) VALUES ('variegated');
INSERT INTO color(name) VALUES ('gray');
INSERT INTO color(name) VALUES ('brown');

/* -- PLANT TYPE -- */
INSERT INTO plant_type(name) VALUES ('herb');
INSERT INTO plant_type(name) VALUES ('vine');
INSERT INTO plant_type(name) VALUES ('succulent');
INSERT INTO plant_type(name) VALUES ('shrub');

/* -- PROPAGATION TECHNIQUES -- */
INSERT INTO propagation_techniques(name) VALUES ('cutting');
INSERT INTO propagation_techniques(name) VALUES ('layering');
INSERT INTO propagation_techniques(name) VALUES ('sowing');
INSERT INTO propagation_techniques(name) VALUES ('division');
INSERT INTO propagation_techniques(name) VALUES ('grafting');

/* -- SEASONS -- */
INSERT INTO seasons(name) VALUES ('spring');
INSERT INTO seasons(name) VALUES ('summer');
INSERT INTO seasons(name) VALUES ('fall');
INSERT INTO seasons(name) VALUES ('winter');


/* -- PLANT TIME -- */
INSERT INTO plant_time(name) VALUES ('bloom time');
INSERT INTO plant_time(name) VALUES ('planting time');
INSERT INTO plant_time(name) VALUES ('harvest time');

/* -- SOIL TYPES -- */
INSERT INTO soil_types(name) VALUES ('sand');
INSERT INTO soil_types(name) VALUES ('clay');
INSERT INTO soil_types(name) VALUES ('chalky');
INSERT INTO soil_types(name) VALUES ('sandy loam');
INSERT INTO soil_types(name) VALUES ('acidic');
INSERT INTO soil_types(name) VALUES ('neutral');
INSERT INTO soil_types(name) VALUES ('loam');
INSERT INTO soil_types(name) VALUES ('alkaline');
INSERT INTO soil_types(name) VALUES ('slightly acidic');
INSERT INTO soil_types(name) VALUES ('slightly alkaline');

/* -- SUNLIGHT INTENSITY -- */
INSERT INTO sunlight_types(intensity) VALUES ('full sun');
INSERT INTO sunlight_types(intensity) VALUES ('full shade');
INSERT INTO sunlight_types(intensity) VALUES ('partial sun');

/* -- HARDINESS ZONES -- */
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 1', -52.1, -45.6);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 2', -45.6, -40);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 3', -40, - 34.4);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 4', -34.4, -28.9);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 5', -28.9, -23.3);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 6', -23.3, -17.8);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 7', -17.8, -12.2);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 8', -12.2, -6.7);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 9', -6.7, -1.1);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 10', -1.1, 4.4);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 11', 4.4, 10);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 12', 10, 15.6);
INSERT INTO hardiness_zones(name, min_temperature, max_temperature) VALUES ('Zone 13', 15.6, 21.1);

/* -- SCIENTIFIC CLASSIFICATION -- */
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (1, 1, 1, 1, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (2, 2, 2, 1, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (3, 3, 3, 2, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (4, 4, 4, 1, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (5, 5, 5, 2, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (6, 1, 1, 1, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (7, 6, 6, 2, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (8, 7, 7, 2, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (9, 8, 8, 2, 1);
INSERT INTO scientific_classification(fk_genus_id, fk_family_id, fk_order_id, fk_class_id, fk_phylum_id) VALUES (10, 5, 5, 2, 1);

/* -- HABITAT -- */
INSERT INTO habitat(name) VALUES ('forests');
INSERT INTO habitat(name) VALUES ('tropical forests');
INSERT INTO habitat(name) VALUES ('garden');
INSERT INTO habitat(name) VALUES ('scrub, amongst bracken and on rocky slopes');
INSERT INTO habitat(name) VALUES ('desert hills, uplands');
INSERT INTO habitat(name) VALUES ('tropical forests');
INSERT INTO habitat(name) VALUES ('river banks, thickets, sparse forests');
INSERT INTO habitat(name) VALUES ('cultivated beds');
INSERT INTO habitat(name) VALUES ('tropical moist forest');

/* -- PLANT -- */
INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning, potting_suggestions, 
                difficulty_description, symbolism,
                fk_scientific_classification) 
VALUES ('monstera deliciosa', true, 'The swiss cheese plant (Monstera deliciosa) produces bright, glossy leaves and makes a popular houseplant. It is originally native to tropical forest regions in Central America. The nickname swiss cheese plant refers to the small holes that develop in the plant''s leaves. The long fruits resemble corncobs and smell sweet and fragrant when ripe.', 
        -1, null, 'Its leaves are evergreen and extremely shade-tolerant. It is a famous indoor foliage plant. It is commonly used as potted ornamentals in Europe, America and Japan to decorate living rooms and windowsills.', 20, 6,  
        30, 1, 'It is important to avoid overwatering because the plant is susceptible to root rot. The plant should be watered after the top few inches of the potting soil have been allowed to dry out from the previous watering. The species will grow well if it is watered in a well-draining pot.',
        'It grows best if it is provided with a balanced fertilizer containing nitrogen phosphorus and potassium. Diluted liquid fertilizer or organic granular fertilizer will work for fertilizing this species. For new plants, it is recommended to fertilize every eight weeks for the first year, then decrease the number in successive years.',
        'Trim the dead, diseased, overgrown branches in winter.', 'Needs excellent drainage in pots.',
        'Easy to take care of, resistant to almost all pests and diseases. Perfect option for gardeners with brown thumbs.', 'Health, longevity, respect for one''s elders.', 
        1); 

INSERT INTO plant(
    botanical_name, 
    poisonous, 
    description,
    min_plant_temperature, 
    max_plant_temperature, 
    plant_height, 
    watering_information,
    fk_scientific_classification
) 
VALUES (
    'goeppertia picturata', 
    false, 
    'Calathea picturata is a species of plant in the family Marantaceae, native to northwest Brazil. It is a clump-forming evergreen perennial growing to 35 to 40 cm. The leaves are dark green above, purple below, marked heavily with silver along the veins and midriff. It is tender, with a minimum temperature of 16 ℃ required, and in temperate areas is cultivated indoors as a houseplant. Under the synonym Goeppertia picturata the cultivar "Argentea", with silver leaves edged in green, has gained the Royal Horticultural Society''s Award of Garden Merit.', 
    16, 
    null, 
    40, 
    'Water calathea monthly, or every 3-4 weeks, with a half-strength balanced fertilizer or a liquid organic fertilizer, such as seaweed or compost tea. This is not necessary during the winter when the plant is in its dormant season.', 
    2
);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning,  
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('peperomia ferreyrae', false, 'Pincushion peperomia (Peperomia ferreyrae) is a perennial semi-succulent native to rainforests of South America. Pincushion peperomia is also commonly known as Happy Beans Peperomia and Green Beans Peperomia. This species is often grown as a houseplant and should be placed in bright indirect sunlight for optimal growth. Pincushion peperomia slightly moist soil, but is also very vulnerable to overwatering.', 
        4, null, 'Despite the fact that the entire genus is named after the flowers, peperomia ferreyraes clusters of small yellow flowers are not valued. Instead, the plant is cherished for its unique foliage. The small size and lack of tendency to spread makes it ideal for small spaces and arrangement - windowsills, dish gardens, desktops conservatories and greenhouses.', 30, 20, 
        2.5, 2, 'Pincushion peperomia likes moist soil and can be sensitive to over-watering, which can lead to rot. Under-watering leads to wilting. Potted Pincushion peperomia needs to be watered regularly during the growth season. Allow the soil to dry before watering. During the winter, water occasionally.', 
        'Use a diluted liquid fertilizer bi-weekly for pincushion peperomia during spring. In the summer, you need only apply the solution once a month. It is not necessary to apply any fertilizer during the autumn or winter.',
        'Trim the diseased, withered leaves once a month.', 
        'Easy to take care of, resistant to almost all pests and diseases. Perfect option for gardeners with brown thumbs.', 'Friendship and devotion',
        3);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning, potting_suggestions, 
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('goeppertia zebrina', false, 'Zebra plant (goeppertia zebrina) is an evergreen perennial that will grow from 61 to 91 cm tall, with light green leaves accented by dark green stripes. It blooms in summer with purple or white flowers. Prefers partial sun to full shade. Propagate this plant by dividing it every 2 to 3 years. Requires excellent drainage and high humidity. Grows best in indoor gardens and large terrariums.', 
        15, null, 'The zebra plant leaf surface is velvety, and is dark green with yellow-green stripes. The back of tender young leaves are light grey-green and the back of old leaves are lilac-red.', 100, 50, 
        2.5, 3, 'Zebra plant loves moisture and hates soaking wet feet, so frequent, even waterings are the best for your plant. When the top of the soil feels dry, thoroughly water your Zebra plant and allow the substrate to drain. It will likely need more frequent water during the growing season.', 
        'Zebra plant likes fertile soil, so frequent applications of fertilizer are recommended for this plant. Starting in spring and ending late summer, give your plant a balanced liquid fertilizer at 1/4 strength once every 2-4 weeks, depending on the quality of the soil. Be sure not to overfertilize, though!',
        'Trim the diseased, withered leaves once a month.', 'It is recommended to repot once every 1-2 years.', 
        'Not difficult to take care of. With proper care it will grow well in certain environments.', 'Good luck and happiness.',
        2);

INSERT INTO plant(botanical_name, poisonous, description,
min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread,
flower_size, fk_habitat_id, watering_information,
fertilization_information,
symbolism,
fk_scientific_classification)
VALUES ('lilium bulbiferum', true, 'Orange lily (Lilium bulbiferum) is a flowering herbaceous lily species native to Europe. This species is toxic to cats. Its scientific name means bearing bulbs. Orange lily is the symbol of the Orange Order, a protestant fraternal order in Ireland.',
null, null, 'Flowers often symbolize certain emotions and meanings. The orange lily is a symbol of confidence, pride and even wealth. Giving the orange lily as a gift is the perfect sentiment for someone getting a job promotion or a recent graduate. Lilies have been symbolic in many cultures, even in ancient Greek mythology.', 120, 30,
15, 4, 'The Orange lily should be watered only when the top layer of soil feels dry to the touch. The most effective method for determining this is to stick a finger tip into the soil to feel whether it''s dry or still moist. If the soil is dry, it is time to water again.',
'The orange lily should be fertilized with a slow-release fertilizer on the top layer of soil. This species is considered a heavy feeder and will benefit from the addition of fertilizer to the soil. A commercial, slow-release fertilizer with a 14-14-14 nitrogen, phosphorous, and potassium formulation is sufficient. The plant should be fertilized at the time of planting, and then once monthly during the active spring and fall growing season.',
'It is generally thought of to represent emotions such as confidence and at the extreme, pride.',
4);

INSERT INTO plant(botanical_name, poisonous, description,
min_plant_temperature, max_plant_temperature, plant_height, spread,
flower_size, fk_habitat_id, watering_information,
fertilization_information,
pruning, potting_suggestions,
difficulty_description, symbolism,
fk_scientific_classification)
VALUES ('opuntia microdasys', false, 'Angels-wings (Opuntia microdasys) is a flowering cactus species native to Mexico. Angel''s-wings is closely related to Opuntia microdasys var. rufida, which can be differentiated from Opuntia microdasys by its reddish color. Some scientists consider the two cacti to be the same species. This species is also known as the bunny ears cactus, the bunny cactus, or the polka-dot cactus. It is sometimes planted as an ornamental on borders and in gardens.',
-7, null, 100, 60,
5, 5, 'Water Angel''s-wings once every two to three weeks, letting the soil dry out between waterings. During its first season, however, keep the soil slightly moist to help the root system establish well. Stop watering entirely during winter.',
'Fertilize Angel''s-wings once monthly with a balanced (such as 20-20-20) or low-nitrogen plant food. Stop fertilizer in late fall, and resume in early spring.',
'Shape the plant every 2 months during the growing season.', 'Needs excellent drainage in pots.',
'Easy to take care of, resistant to almost all pests and diseases. Perfect option for gardeners with brown thumbs.', 'Hope.',
5);

INSERT INTO plant(botanical_name, poisonous, description, min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, flower_size, fk_habitat_id, watering_information, fertilization_information, pruning, potting_suggestions, difficulty_description, symbolism, fk_scientific_classification) 
VALUES ('epipremnum aureum', true, 'The golden pothos (Epipremnum aureum) is a popular houseplant that is commonly seen in Australia, Asia, and the West Indies. It goes by many nicknames, including devil''s ivy, because it is so hard to kill and can even grow in low light conditions. Golden pothos has poisonous sap, so it should be kept away from pets and children.', 
        -1, null, 'The golden pothos is a popular houseplant, largely due to the way in which it cleans the air. In newly-renovated homes, the golden pothos has been shown to absorb benzene, tricholoethylene and formaldehyde, although you cannot rely on the plant alone to remove all harmful gases from a room. Nevertheless, they have tenacious vitality, and can quickly convert formaldehyde into sugars or amino acids, while decomposing any benzene emitted by photocopiers and printers, making it no surprise that this plant is often seen in homes and offices.', 2000, 30, 
        2.5, 6, 'Golden pothos grows best in moist soil with medium humidity. When growing golden pothos, it is beneficial to mist the plant''s leaves regularly with a spray bottle to maintain humidity around the leaf area. The top layer of soil should be allowed to dry between waterings, and the plant will grow best if it is kept in a pot with a draining hole in the bottom.', 
        'Golden pothos requires fertilization for optimal growth. A water soluble fertilizer diluted by half is ideal for fertilizing this species. Between the spring and fall, golden pothos should be fertilized every couple of weeks. In the winter, fertilization can occur monthly. If the plant''s leaves turn yellow, it is a sign that more fertilization is necessary.',
        'Shape the plant every 2 months during the growing season.', 'Repot in the spring, choosing a container that''s no more than 5 cm larger than the plant''s rootball. Use a nutrient-rich, soil-based potting mix.', 
        'Easy to take care of, resistant to almost all pests and diseases. Perfect option for gardeners with brown thumbs.', 'Happiness, good fortune, determination to achieve one''s goals, wealth.',
        6);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning, potting_suggestions, 
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('Rosa chinensis', false, 'The China rose (Rosa chinensis) is a native of Southwest China. The plant has been cultivated for so long that it has become hard to tell the difference between wild and cultivated varieties. With medium-sized clusters of flowers and a long blooming season, it is easy to see why the China rose was chosen as the basis for many rose hybrids.', 
        -23, null, 'The China rose has many different colors, each with a different meaning. Red symbolizes love, while pink stands for first love. White represents purity and loyalty and blue expresses affection. People seldom send black roses, because although these have a number of meanings, most of them are negative. So, if you are giving these flowers as a gift, choose a color based on your intentions.', 200, 183, 
        5, 3, 'The China rose is fairly drought-tolerant but benefits from frequent watering during its flowering time. Water the lower section of the plant and the soil around it, without wetting the leaves if possible. For roses planted in the ground, water until the area seems waterlogged and a small puddle forms around the stems. Water again when the top layer of soil feels dry.', 
        'Fertilize your China rose with a balanced liquid fertilizer every two weeks during the growing period. Dilute the fertilizer into the water that you use for normal watering. You can also apply manure or garden compost in spring, during planting. Roses planted in containers or pots should be fertilized more often than those planted in the ground.',
        'Trim the dead, diseased, and overgrown branches in winter.', 'Increase pot diameter year by year, and replace pots before or after the winter each year. Masonry pots are preferred for potting.', 
        'The China rose is easy to take care of and is resistant to almost all pests and diseases, making it a perfect option for gardeners with brown thumbs.', 'Happiness, longevity, and eternal spring.',
        7);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning, potting_suggestions, 
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('chrysanthemum x morifolium', true, 'Florist''s daisy is a Chinese native that has been cultivated as a medicinal and decorative plant for over 2000 years. Today, it is a gardening and florist favorite all over the world. Chrysanthemum × morifolium is a bushy perennial with dark-green leaves and numerous compact flower heads that come in a wide variety of colors. In English, it is affectionately known as “Mum.”', 
        null, null, 'The crysanthemum is related to the Roman Catholic Pope, having a noble and true meaning. It is generally believed that this flower has a refined and outstanding temperament. The chrysanthemum enjoys a high status in Japan, where it is a part of the crest of the Japanese royal family. It represents longing for beauty, freedom and nature. The Japanese also use chrysanthemum to sweep graves, worship ancestors and also in new year celebrations. Different kinds of chrysanthemums represents divination for love; winter chrysanthemums for parting and yellow ones for being successful. In China, it has the meaning of nobility and longevity; in Europe it means nobility. Take careful consideration of the meaning of the chrysanthemum if you want to give it to someone as a gift, as they are often used to memorialize the deceased.', 90, 60, 
        4, 8, 'The Florist''s daisy should be watered to the extent that their soil is kept evenly moist at all times. When planted in a pot, it must be watered often and kept in a well-draining pot. Watering once or twice a week is sufficient for this species during the active growing period between spring and fall.', 
        'The florist''s daisy does not need to be fertilized in order to grow efficiently. If fertilization is preferred, a well-balanced, liquid houseplant fertilizer should be applied during waterings.',
        'Trim the diseased, withered leaves once a month.', 'Needs excellent drainage in pots.', 
        'Easy as long as you can give them what they need. They are sensitive to certain types of pests and diseases.', 'Purity, nobility and longevity',
        8);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                potting_suggestions, 
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('ixora chinesis', false, 'Chinese ixora (Ixora chinensis) is a tropical evergreen shrub native to China and thus sometimes called simply Chinese Ixora. The red berries and clusters of bright flowers that bloom nearly year-round make this a popular ornamental plant.', 
        null, null, 'It is said that the Ishtha people in Myanmar have a very romantic and interesting marriage custom. Since ancient times, they have lived near the water. Every family with a daughter would build near their house a floating garden with bamboo and wood, planting chinese ixora on it, and then tie it with ropes. On the daughter''s wedding day, they would dress her up beautifully, then have her sit in the floating garden, and finally cut off the rope and let it float down the river. Early in the morning, the groom would wait on a downstream shore, ready to welcome the small garden carrying the bride. When the garden boat arrived, the groom would grab the rope and pull it ashore, then lead the bride home for the wedding.', 500, 0, 
        3, 7, 'Average water needs, watering when the top 3 cm of soil has dried out.', 
        'Fertilization once every 2-3 months during the growing season.',
        'Potted plants should be repotted every 1-2 years.', 
        'Easy to take care of, resistant to almost all pests and diseases. Perfect option for gardeners with brown thumbs.', 'Rush to the fore!',
        9);

INSERT INTO plant(botanical_name, poisonous, description, 
                min_plant_temperature, max_plant_temperature, interesting_fact, plant_height, spread, 
                flower_size, fk_habitat_id, watering_information,
                fertilization_information, 
                pruning, 
                difficulty_description, symbolism,
                fk_scientific_classification)  
VALUES ('epiphyllum oxypetalum', false, 'Queen of the night is a unique flowering plant. Its flowers are funnel-shaped and have clean white petals and an aromatic scent. Each flower blooms on a single quiet night and fades within hours, making the plant a veritable moonlight beauty.', 
        -7, null, 'Legend goes that the queen of the night flower was punished by a god and could only bloom for just one moment every year. In order to meet her beloved one who collected morning dew for Buddha every year, she could only choose to bloom at that time. So a years worth of charm was put into her blooming at that one moment, hoping her beloved would notice.', 600, 120, 
        17, 9, 'During the growing season, water your Queen of the night whenever the surface of the soil dries out, making sure that the soil drains properly afterward. In winter, cut back watering by at least half.', 
        'Apply a dose of diluted 20-20-20 liquid fertilizer to your queen of the night plant''s soil every month from spring through fall. A lower-nitrogen fertilizer may also work well, as this plant is sensitive to nitrogen and may grow leggy stems and fewer blooms when over-fertilized.',
        'Shape the plant every 2 months during the growing season.',
        'Easy as long as you can give them what they need. They are sensitive to certain types of pests and diseases.', 'Instant beauty, immortality, luck, prosperity.',
        10);

/* -- PLANT NAMES -- */
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('swiss cheese plant', 'This plant has always been loved for its unique leaves. During the seedling stage, its leaves are intact as a whole. However, as it ages, the leaves begin to pop out holes and lobes. The older it gets, the larger the holes and the larger the leaves are. This makes its leaves very similar looking to the holes in cheese, so it will be called Swiss cheese plant.', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('tarovine', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('fruit salad plant', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('ceriman', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('mexican breadfruit', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('swiss cheese plant', 1);
INSERT INTO plant_names(name, fk_plant_id) VALUES('calathea', 2);
INSERT INTO plant_names(name, fk_plant_id) VALUES('variegated prayer plant', 2);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('pincushion peperomia', 'The genus name Peperomia means name Pepper-like in Latin. That refers to the pepper-like shape of flowers of these plants. The first part of the common name, pincushion, refers to elongated, densely-packed pointy leaves, which makes it stand out from other species of the genus.', 3);
INSERT INTO plant_names(name, fk_plant_id) VALUES('happy bean', 3);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('zebra plant', 'The emerald green leaves of Goeppertia zebrina are covered in dark green stripes that look like the stripes of a zebra. Therefore, Goeppertia zebrina got its common name zebra plant. The specific epithet ''zebrina'' in its botanical name means ''of zebra'' and it refers to its variegated leaves.', 4);
INSERT INTO plant_names(name, fk_plant_id) VALUES('orange lily', 5);
INSERT INTO plant_names(name, fk_plant_id) VALUES('jimmy''s bane', 5);
INSERT INTO plant_names(name, fk_plant_id) VALUES('fire lily', 5);
INSERT INTO plant_names(name, fk_plant_id) VALUES('tiger lily', 5);
INSERT INTO plant_names(name, fk_plant_id) VALUES('angel''s wings', 6);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('bunny ears cactus', 'It has become a popular houseplant because it is easy to take care of the plant and it has a cute appearance with great blooms. However, yellow flowers appear rarely. Despite this, it is very popular in cultivation because of the comical resemblance to a rabbits head. Therefore, it is called bunny ears cactus.', 6);
INSERT INTO plant_names(name, fk_plant_id) VALUES('cinnamon cactus', 6);
INSERT INTO plant_names(name, fk_plant_id) VALUES('bunny-ear prickly-pear', 6);
INSERT INTO plant_names(name, fk_plant_id) VALUES('bunny ears', 6);
INSERT INTO plant_names(name, fk_plant_id) VALUES('polka dot cactus', 6);
INSERT INTO plant_names(name, story, fk_plant_id) VALUES('golden pothos', 'Since its green leaves are laced with the color gold, it is called Golden Pothos. Epipremnum aureum has a long and tortuous naming history, and it has been reclassified several times. It was first classified as Pothos aureus. In 1962, scholars discovered that it actually had a blossoming phase. Since then, scholars closely observed and investigated the plants flowers, leaves and growth, and determined its latin name to be Epipremnum aureum.', 7);
INSERT INTO plant_names(name, story, fk_plant_id) VALUES('devil''s ivy', 'Even if kept in the dark, it can stay green the whole year long, just like the tenacity of the devil. It is also known as devils ivy because it is almost impossible to kill.', 7);
INSERT INTO plant_names(name, fk_plant_id) VALUES('ceylon creeper', 7);
INSERT INTO plant_names(name, fk_plant_id) VALUES('ivy arum', 7);
INSERT INTO plant_names(name, fk_plant_id) VALUES('money plant', 7);
INSERT INTO plant_names(name, fk_plant_id) VALUES('hunters robe', 7);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('garden rose', 'Rosa chinensis has many horticultural varieties, so it has many common names. Since it is most commonly used in gardens, and is also one of the most common plants found in a garden, its most popular name is the china rose.', 8);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('china rose', 'As per its name, the Rosa chinensis originates from China, and is one of the flowers that represents the country.', 8);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('bengal rose', 'Bengal rose was also a historically-famous name for the plant, as it was used in Bengal to make dye.', 8);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('Florist''s daisy', 'Chrysanthemum × morifolium is a hybrid chrysanthemum often referred to as florists daisy. The common name probably comes from the fact that florists daisy is an important chrysanthemum in the floral industry. There are more than 100 cultivars released within the species Chrysanthemum × morifolium.', 9);
INSERT INTO plant_names(name, fk_plant_id) VALUES('hardy garden mum', 9);
INSERT INTO plant_names(name, fk_plant_id) VALUES('chrysanthemum', 9);
INSERT INTO plant_names(name, fk_plant_id) VALUES('chinese ixora', 10);
INSERT INTO plant_names(name, fk_plant_id) VALUES('queen of the night', 10);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('dutchmans pipe cactus', 'Epiphyllum oxypetalum is also called Dutchmans Pipe cactus because of its curved tube. It is perhaps the most commonly seen of the Epiphyllum genus. Although it blooms better in smaller pots, it somewhat makes a more attractive houseplant before bloom.', 10);
INSERT INTO plant_names(name, fk_plant_id) VALUES('princess of the night', 10);
INSERT INTO plant_names(name, fk_plant_id) VALUES('jungle cactus', 10);
INSERT INTO plant_names(name, fk_plant_id) VALUES('orchid cactus', 10);
INSERT INTO plant_names(name, fk_plant_id) VALUES('lady of the bight', 10);
INSERT INTO plant_names(name, story, fk_plant_id)
VALUES('nightblooming cereus', 'It blooms rarely and only at night and the flowers wilt before dawn. Though it is sometimes referred to as a Nightblooming cereus, it is not closely related to any of the species in the tribe Cereeae, such as Selenicereus. It is more commonly known as nightblooming cereus. All Cereus species bloom at night and are terrestrial plants while all Epiphyllum species are usually epiphytic.', 10);

/* -- PLANT HARDINESS ZONE -- */
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (1, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (1, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (1, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (1, 13);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (2, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (2, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (3, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (3, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (3, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (4, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (4, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (4, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 3);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 4);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 5);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 6);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 7);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 8);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (5, 9);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (6, 9);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (6, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (6, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (6, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (7, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (7, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (7, 12);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (7, 13);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 5);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 6);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 7);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 8);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 9);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (8, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 5);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 6);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 7);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 8);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 9);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (9, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (10, 9);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (10, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (10, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (11, 10);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (11, 11);
INSERT INTO plant_hardiness_zone(fk_plant_id, fk_hardiness_zone) VALUES (11, 12);

/* -- SUNLIGHT TYPES -- */
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(1, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(2, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(2, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(3, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(4, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(5, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(5, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(6, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(7, 2);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(8, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(9, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(10, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(10, 3);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(11, 1);
INSERT INTO plant_sunlight_conditions(fk_plant_id, fk_sunlight_id) VALUES(11, 3);

/* -- PLANT SOIL -- */
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 2);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 3);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 4);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (1, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (2, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (2, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (2, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (3, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (3, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (3, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (3, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (3, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (4, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (4, 3);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (4, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (4, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (5, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (5, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (5, 2);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (5, 9);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (5, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (6, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (6, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (6, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (6, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (6, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 3);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 2);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 4);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (7, 8);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 2);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 9);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (8, 10);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 2);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 9);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (9, 10);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (10, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (10, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 1);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 7);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 3);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 5);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 6);
INSERT INTO plant_soil(fk_plant_id, fk_soil_id) VALUES (11, 8);

/* -- PLANT PROPAGATION -- */
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(1, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(1, 2);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(1, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(2, 4);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(3, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(4, 4);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(5, 4);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(5, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(6, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(6, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(7, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(7, 2);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(8, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(8, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(8, 5);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(9, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(9, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(10, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(10, 2);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(11, 1);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(11, 3);
INSERT INTO plant_propagation(fk_plant_id, fk_propagation_technique) VALUES(11, 5);

/* -- PLANT TIME SEASON -- */
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 1, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 2, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 3, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(1, 4, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(2, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(3, 1, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(3, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(3, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(3, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(4, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(4, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(4, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(5, 2, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(5, 3, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(5, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(6, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(6, 2, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(6, 1, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(6, 2, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(6, 4, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(7, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(7, 2, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(7, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(7, 4, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 3, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 1, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(8, 3, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(9, 3, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(9, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(9, 3, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(10, 1, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(10, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(10, 3, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(10, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(10, 2, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 1, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 2, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 3, 1);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 1, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 3, 2);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 1, 3);
INSERT INTO plant_time_season(fk_plant_id, fk_season_id, fk_plant_time) VALUES(11, 4, 3);

/* -- PLANT TYPES -- */
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(1, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(1, 2);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(3, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(3, 3);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(4, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(5, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(6, 3);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(6, 4);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(7, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(7, 2);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(8, 2);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(8, 4);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(9, 1);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(10, 4);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(11, 3);
INSERT INTO plant_types(fk_plant_id, fk_plant_type_id) VALUES(11, 4);

/* -- PLANT LIFESPAN -- */
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(1, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(2, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(3, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(4, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(5, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(6, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(7, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(8, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(9, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(9, 2);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(10, 1);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(10, 2);
INSERT INTO plant_lifespan(fk_plant_id, fk_lifespan_id) VALUES(11, 1);

/* -- PLANT PART COLOR -- */
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 2, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 1, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 1, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 2, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 3, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 5, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 11, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 13, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (1, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 12, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 12, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 1, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 15, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 10, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 15, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 10, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (2, 12, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (3, 3, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (3, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (3, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (3, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 12, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 12, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 12, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (4, 1, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 7, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 3, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (5, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 6, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 12, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 8, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 9, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 1, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (6, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 3, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 5, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 1, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 14, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 6, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 7, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 8, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 5, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (7, 2, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 12, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 6, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 4, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 2, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 7, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 11, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 6, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 7, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (8, 16, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 12, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 6, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 4, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 3, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 2, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 7, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 10, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (9, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (10, 7, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (10, 6, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (10, 3, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (10, 3, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 1, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 5, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 3, 1);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 4, 2);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 3, 3);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 4, 4);
INSERT INTO plant_part_color(fk_plant_id, fk_color_id, fk_plant_part_id) VALUES (11, 1, 4);