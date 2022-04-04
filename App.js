import {useState} from 'react';
import React from 'react';
import {StyleSheet, View, FlatList, Button, Text, Image} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

import GoalItem from './components/GoalItem';
import GoalInput from './components/GoalInput';

export default function App() {
  const [modalIsVisible, setModalIsVisible] = useState(false);
  const [courseGoals, setCourseGoals] = useState([]);

  function startAddGoalHandler() {
    setModalIsVisible(true);
  }

  function endAddGoalHandler() {
    setModalIsVisible(false);
  }

  function addGoalHandler(enteredGoalText) {
    setCourseGoals(currentCourseGoals => [
      ...currentCourseGoals,
      {text: enteredGoalText, id: Math.random().toString()},
    ]);
    endAddGoalHandler();
  }

  function deleteGoalHandler(id) {
    setCourseGoals(currentCourseGoals => {
      return currentCourseGoals.filter(goal => goal.id !== id);
    });
  }

  return (
    <View style={styles.appContainer}>
      <Button
        title="Yeni Hedef Ekle"
        color="#f4578c"
        onPress={startAddGoalHandler}
      />
      <GoalInput
        visible={modalIsVisible}
        onAddGoal={addGoalHandler}
        onCancel={endAddGoalHandler}
      />

      <View style={styles.goalsContainer}>
        <FlatList
          data={courseGoals}
          renderItem={itemData => {
            return (
              <GoalItem
                text={itemData.item.text}
                id={itemData.item.id}
                onDeleteItem={deleteGoalHandler}
              />
            );
          }}
          keyExtractor={(item, index) => {
            return item.id;
          }}
          alwaysBounceVertical={false}
        />
      </View>
      <View>
        <Text style={styles.textStyle}>
          <Image
            style={styles.imageStyle}
            source={require('./images/warning2.png')}
          />
          Silmek istediğiniz seçeneğin üstüne tıklamanız yeterli.
        </Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  appContainer: {
    flex: 1,
    padding: 50,
    paddingHorizontal: 16,
    backgroundColor: 'white',
  },

  goalsContainer: {
    flex: 5,
  },
  textStyle: {
    color: 'black',
    fontSize: 14,
  },
  imageStyle: {
    width: 30,
    height: 0,
  },
});
