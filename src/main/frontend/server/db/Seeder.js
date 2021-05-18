import pg from "pg"

const pool = new pg.Pool({
  connectionString: "postgres://postgres:password@localhost:5432/adopt_a_pet"
})

class Seeder {
  static async seed() {
    try {
      await pool.query(
        "INSERT INTO pet_types (type, img_url, description) VALUES ( 'Cat', 'https://cdn.britannica.com/22/206222-131-E921E1FB/Domestic-feline-tabby-cat.jpg', 'Adorable, furry tyrants' ), ('Dog', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*', 'Your new slobbery best friend'), ('Mowai', 'https://www.thesun.co.uk/wp-content/uploads/2020/01/2015Gremlins_GettyImages-163067748261115-920x610-696x442-1.jpg', 'Do not feed after midnight');"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Ron Purrlman', 'https://static.wixstatic.com/media/035bec_f0e960d1567648d989fd490f79fd46d7~mv2.jpg/v1/fill/w_640,h_806,al_c,q_85,usm_0.66_1.00_0.01/035bec_f0e960d1567648d989fd490f79fd46d7~mv2.webp', 5, true, 'Mr Purrlman wishes to retire from the limelight of Hollywood and settle down somewhere on the ocean with a nice family that will give him lots of chin scritches.', 'Available', 1);"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Daisy', 'https://myanimals.com/wp-content/uploads/2018/06/old-dogs-sleep-a-lot-461x307.jpg', 9, true, 'Daisy just wants to live somewhere warm and be driven around so she can stick her head out of the window.', 'Available', 2 );"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Gizmo', 'https://www.thesun.co.uk/wp-content/uploads/2020/01/2015Gremlins_GettyImages-163067748261115-920x610-696x442-1.jpg', 1, false, 'Gizmo comes from a mysterious far away land and is looking for someone to cuddle and talk to him', 'Available', 3);"
      )
      pool.end()
    } catch (error) {
      console.error(error)
      pool.end()
    }
  }
}

export default Seeder
